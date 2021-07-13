package com.magdalena.cardcollection.ui.chooseCategory

import androidx.lifecycle.MutableLiveData
import com.magdalena.cardcollection.database.Category
import com.magdalena.cardcollection.manger.CardDatabaseManger
import com.magdalena.cardcollection.manger.CategoryDatabaseManger
import com.magdalena.cardcollection.ui.base.BaseViewModel
import com.magdalena.cardcollection.ui.home.adapter.CardItem
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ChooseCategoryViewModel : BaseViewModel() {

    val categories: MutableLiveData<MutableList<Category>> = MutableLiveData()

    @Inject
    lateinit var categoryDatabaseManger: CategoryDatabaseManger

   fun getCategories() {
        disposables.add(
            Observable.fromCallable {
                categoryDatabaseManger.getCategories()
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    categories.value = it
                }, {

                })
        )
    }
}