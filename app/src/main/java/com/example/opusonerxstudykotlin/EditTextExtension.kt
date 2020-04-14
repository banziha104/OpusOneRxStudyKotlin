package com.example.opusonerxstudykotlin

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

fun EditText.onTextChange() : Observable<Editable?>{
    val subject = BehaviorSubject.create<Editable?>()
    this.addTextChangedListener(object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            s?.let {
                subject.onNext(it)
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    })
    return subject
}