package com.jasolsodha.mynotesoncloud

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.jasolsodha.mynotesoncloud.util.CommonUtils

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

    // TODO
    // this can probably depend on isLoading variable of BaseViewModel,
    // since its going to be common for all the activities
    private lateinit var mProgressDialog: Dialog
    private lateinit var   mViewDataBinding : T
    protected lateinit var mViewModel : T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }


    fun performDataBinding(){
        mViewDataBinding = DataBindingUtil.setContentView<T>(this, getLayoutResId())
        mViewDataBinding.setVariable(getBindingVariable(),mViewModel)
        mViewDataBinding.executePendingBindings()
    }

    @LayoutRes
    abstract fun getLayoutResId(): Int

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    abstract fun getBindingVariable(): Int

    //TODO
    //Internet Checking

    protected fun getViewDataBinding() = mViewDataBinding

    protected fun showLoading() {
        hideLoading()
        mProgressDialog = CommonUtils.showLoadingDialog(this)
        mProgressDialog.show()
    }


    protected fun hideLoading() {

        if (mProgressDialog.isShowing) {
            mProgressDialog.let {
                it.dismiss()
            }
        }
    }

    open fun hideKeyboard() {
        val view: View? = this.currentFocus
        if (view != null) {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
            }
        }
    }


}