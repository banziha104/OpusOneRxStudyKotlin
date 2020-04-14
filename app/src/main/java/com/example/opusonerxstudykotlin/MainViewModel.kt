package com.example.opusonerxstudykotlin

import android.app.Application
import android.content.Context
import android.widget.EditText
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val context : Context = getApplication<Application>()

    fun getTextChangeObservable(editTextId: EditText, editTextPs: EditText): Observable<Pair<String,String>> =
        Observables
            .combineLatest(
                editTextId.onTextChange(),
                editTextPs.onTextChange()
            ) { e1, e2 -> e1 to e2 } // Observable<Pair<Editable?,Editable?>>
            .map { (first, second) -> first.toString() to second.toString() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}