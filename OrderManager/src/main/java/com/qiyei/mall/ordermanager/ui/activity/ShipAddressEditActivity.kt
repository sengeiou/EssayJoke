package com.qiyei.mall.ordermanager.ui.activity


import android.os.Bundle
import android.view.View
import com.qiyei.framework.titlebar.CommonTitleBar
import com.qiyei.framework.ui.activity.BaseMVPActivity
import com.qiyei.mall.ordermanager.R
import com.qiyei.mall.ordermanager.injection.component.DaggerOrderManagerComponent
import com.qiyei.mall.ordermanager.injection.module.AddressManagerModule
import com.qiyei.mall.ordermanager.mvp.presenter.ShipAddressEditPresenter
import com.qiyei.mall.ordermanager.mvp.view.IShipAddressEditView
import kotlinx.android.synthetic.main.activity_ship_address_edit.*
import org.jetbrains.anko.toast

class ShipAddressEditActivity : BaseMVPActivity<ShipAddressEditPresenter>() ,IShipAddressEditView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ship_address_edit)
        initView()
    }

    override fun initComponentInject() {
        DaggerOrderManagerComponent.builder()
                .activityComponent(mActivityComponent)
                .addressManagerModule(AddressManagerModule())
                .build()
                .inject(this)
        mPresenter.mView = this
    }

    override fun onClick(view: View) {
        super.onClick(view)
        when(view.id){
            R.id.mSaveButton -> {
                addAddress()
            }
        }
    }

    override fun onAddShipAddress(result: Boolean) {
        if (result == true ){
            toast("添加地址成功")
        }else {
            toast("添加地址失败")
        }
        finish()
    }

    private fun initView(){
        mTitleBar = CommonTitleBar.Builder(this)
                .setTitle(getString(R.string.new_address))
                .build()

        mSaveButton.setOnClickListener(this)
    }

    /**
     * 添加地址
     */
    private fun addAddress(){
        if (mShipNameEditText.text.isNotEmpty() && mShipMobileEditText.text.isNotEmpty()
                && mShipAddressEditText.text.isNotEmpty()){
            mPresenter.addShipAddress(mShipNameEditText.text.toString(),mShipMobileEditText.text.toString(),
                    mShipAddressEditText.text.toString())
        }

    }
}
