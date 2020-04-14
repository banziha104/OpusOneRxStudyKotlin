package com.example.opusonerxstudykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(MainViewModel::class.java)
//        editID
//            .onTextChange()
//            .subscribeOn(Schedulers.io())
//            .map { it.toString() }
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe{
//                if(it.length > 10) {
//                    txtInfo.text = "아이디"
//                }
//            }
        viewModel.getTextChangeObservable(editID,editPs)
            .subscribe { (id,ps) ->
                if (id.length > 10){

                }

                if(ps.length > 5){

                }
            }


    }

}

