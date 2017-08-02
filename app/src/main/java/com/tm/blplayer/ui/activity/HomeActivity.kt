package com.tm.blplayer.ui.activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.tm.blplayer.R
import com.tm.blplayer.base.BaseActivity
import com.tm.blplayer.ui.fragment.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.include_common_toolbar.*
import java.util.*

class HomeActivity : BaseActivity() {
    private val tabs = arrayOf("直播", "推荐", "番剧", "分区", "动态", "发现")
    private val fragments = ArrayList<Fragment>()

    private var mExitTime = 0L

    override val layoutId: Int
        get() = R.layout.activity_home

    override fun initView() {
        initTab()
        view_pager.offscreenPageLimit = tabs.size
        view_pager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return fragments[position]
            }

            override fun getPageTitle(position: Int): CharSequence {
                return tabs[position]
            }

            override fun getCount(): Int {
                return tabs.size
            }
        }
        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        view_pager.currentItem = 1
        tab_layout.setupWithViewPager(view_pager)
    }

    override fun initData() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // TODO: show explanation
            } else {
                ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the task you need to do.
                } else {
                    // permission denied, boo! Disable the functionality that depends on this permission.
                }
            }
        }
    }

    override fun initToolbar() {
        super.initToolbar()
        ll_menu.visibility = View.VISIBLE
        ll_home_button.visibility = View.VISIBLE
    }

    /**
     * 初始化TAB
     */
    private fun initTab() {
        val mLiveFragment = LiveFragment()
        val mRecommendFragment = RecommendFragment()
        val mBangumiFragment = BangumiFragment()
        val mCategoryFragment = CategoryFragment()
        val mTrendsFragment = TrendsFragment()
        val mDiscoverFragment = DiscoverFragment()

        fragments.add(mLiveFragment)
        fragments.add(mRecommendFragment)
        fragments.add(mBangumiFragment)
        fragments.add(mCategoryFragment)
        fragments.add(mTrendsFragment)
        fragments.add(mDiscoverFragment)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        when (view?.id) {
            R.id.ll_menu -> draw_layout.openDrawer(Gravity.START)
            R.id.iv_game -> {
            }
            R.id.iv_download -> {
            }
            R.id.iv_search -> {
            }
        }
    }

    override fun onBackPressed() {
        val currentTimeMillis = System.currentTimeMillis()
        if (currentTimeMillis - mExitTime <= 2000) {
            System.exit(0)
        } else {
            Toast.makeText(this, resources.getString(R.string.home_exit_hint), Toast.LENGTH_SHORT).show()
            mExitTime = currentTimeMillis
        }
    }

    companion object {
        private val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1
    }
}
