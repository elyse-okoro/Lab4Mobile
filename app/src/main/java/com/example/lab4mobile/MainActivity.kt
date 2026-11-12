package com.example.lab4mobile

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.forEach
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUiSaveStateControl
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.lab4mobile.data.model.CategoryId
import com.example.lab4mobile.databinding.ActivityMainBinding
import com.example.lab4mobile.ui.CloseDrawerOnBackCallback
import com.example.lab4mobile.ui.DrawerCategories
import com.example.lab4mobile.ui.categories.CategoriesFragmentDirections

/**
 * Единственная активность: панель приложения, нижняя навигация и боковая панель.
 * Экраны — фрагменты из nav_graph.xml.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    /** В обычной разметке корень — DrawerLayout; на планшете панель постоянная и его нет. */
    private val drawerLayout: DrawerLayout?
        get() = binding.root as? DrawerLayout

    @OptIn(NavigationUiSaveStateControl::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.content.toolbar)
        applyWindowInsets()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        // без DrawerLayout (планшет) кнопки меню в панели приложения нет: панель и так видна
        appBarConfiguration = AppBarConfiguration(TOP_LEVEL_DESTINATIONS, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        // вкладка всегда открывается со своего первого экрана: граф плоский, и восстановленный
        // стек вкладки мог бы закончиться экраном места, которого нет в нижнем меню
        NavigationUI.setupWithNavController(binding.content.bottomNav, navController, false)

        binding.navView.setNavigationItemSelectedListener { item -> onDrawerItemSelected(item) }
        navController.addOnDestinationChangedListener { _, destination, arguments ->
            showCheckedDrawerItem(DrawerCategories.checkedItemFor(destination.id, arguments))
            showBottomNav(destination.id !in DRAWER_ONLY_DESTINATIONS)
        }
        drawerLayout?.let { drawer ->
            val closeDrawerCallback = CloseDrawerOnBackCallback(drawer)
            drawer.addDrawerListener(closeDrawerCallback)
            onBackPressedDispatcher.addCallback(this, closeDrawerCallback)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // NavigationView восстанавливает своё прежнее выделение уже после onCreate — сверяем с текущим экраном
        navController.currentBackStackEntry?.let { entry ->
            showCheckedDrawerItem(DrawerCategories.checkedItemFor(entry.destination.id, entry.arguments))
        }
    }

    override fun onSupportNavigateUp(): Boolean =
        navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    @OptIn(NavigationUiSaveStateControl::class)
    private fun onDrawerItemSelected(item: MenuItem): Boolean {
        val categoryId = DrawerCategories.categoryFor(item.itemId)
        val handled = if (categoryId != null) {
            openCategory(categoryId, item.title.toString())
            true
        } else {
            NavigationUI.onNavDestinationSelected(item, navController, false)
        }
        drawerLayout?.closeDrawer(GravityCompat.START)
        return handled
    }

    /** Категория из боковой панели открывается во вкладке «Категории»: «Назад» ведёт к списку категорий. */
    private fun openCategory(categoryId: CategoryId, title: String) {
        navController.navigate(R.id.categoriesFragment, null, navOptions {
            launchSingleTop = true
            popUpTo(R.id.homeFragment)
        })
        navController.navigate(CategoriesFragmentDirections.actionCategoriesToPlaces(categoryId, title))
    }

    /** Выделяет в боковой панели пункт текущего экрана; на остальных экранах выделения нет. */
    private fun showCheckedDrawerItem(checkedItemId: Int?) {
        binding.navView.menu.forEach { section ->
            section.subMenu?.forEach { item -> item.isChecked = item.itemId == checkedItemId }
        }
    }

    private fun showBottomNav(visible: Boolean) {
        val bottomNav = binding.content.bottomNav
        if (bottomNav.isVisible == visible) return
        bottomNav.isVisible = visible
        ViewCompat.requestApplyInsets(binding.content.root)
    }

    private fun applyWindowInsets() {
        val content = binding.content
        ViewCompat.setOnApplyWindowInsetsListener(content.root) { _, insets ->
            val bars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            content.appBar.updatePadding(left = bars.left, top = bars.top, right = bars.right)
            // от системной навигации внизу отступает BottomNavigationView, а без неё — сам экран
            val bottom = if (content.bottomNav.isVisible) 0 else bars.bottom
            content.navHostFragment.updatePadding(left = bars.left, right = bars.right, bottom = bottom)
            insets
        }
    }

    private companion object {
        /** Экраны первого уровня: на них в панели приложения кнопка меню, а не стрелка «Назад». */
        val TOP_LEVEL_DESTINATIONS = setOf(
            R.id.homeFragment,
            R.id.categoriesFragment,
            R.id.favoritesFragment,
            R.id.aboutFragment,
            R.id.settingsFragment
        )

        /** Разделы только из боковой панели: вкладок для них нет, нижнюю панель прячем. */
        val DRAWER_ONLY_DESTINATIONS = setOf(R.id.aboutFragment, R.id.settingsFragment)
    }
}
