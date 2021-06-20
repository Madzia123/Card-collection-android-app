package com.magdalena.cardcollection.ui.base

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.google.android.material.snackbar.Snackbar


open class BaseFragment : Fragment() {

    private var toolbarInteraction: ToolbarInteraction? = null

    protected var navigate: NavController? = null

    protected var toolbarIsBackView: Boolean = false
        set(value) {
            field = value
            toolbarInteraction?.showToolbarTitle(value)
        }


    protected var toolbarVisible: Boolean = false
        set(value) {
            field = value
            toolbarInteraction?.isVisibleToolbar(value)
        }

    protected var toolbarTitleRes: Int = 0
        set(value) {
            field = value
            toolbarTitle = getString(field)
        }

    protected var toolbarTitle: String = ""
        set(value) {
            field = value
            toolbarInteraction?.setToolbarTitle(value)
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigate = (context as? NavigationInteraction)?.getNavigationController()
        toolbarInteraction = activity as ToolbarInteraction
    }


    override fun onDetach() {
        super.onDetach()
        navigate = null
        toolbarInteraction = null
    }

    fun showErrorMessage(message: String, view: View) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        snackbar.show()
    }


}