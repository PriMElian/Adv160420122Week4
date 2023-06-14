package com.example.adv160420122week4.view

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.adv160420122week4.R
import com.example.adv160420122week4.util.createNotificationChannel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    /*init {
        instance = this;
    }

    companion object {
        private var instance:MainActivity ?= null

        fun showNotification(title:String, content:String, icon:Int) {
            val channelId = "${instance?.packageName}-${instance?.getString(R.string.app_name)}"

            val notificationBuilder = NotificationCompat.Builder(instance!!.applicationContext, channelId).apply {
                setSmallIcon(icon)
                setContentTitle(title)
                setContentText(content)
                setStyle(NotificationCompat.BigTextStyle())
                priority = NotificationCompat.PRIORITY_DEFAULT
                setAutoCancel(true)
            }

            val notificationManager = NotificationManagerCompat.from(instance!!.applicationContext)
            if (ActivityCompat.checkSelfPermission(
                    instance!!.applicationContext,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            notificationManager.notify(1001, notificationBuilder.build())
        }
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT,
            false, getString(R.string.app_name), "App notification channel.")

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val observable = Observable.timer(5, TimeUnit.SECONDS).apply {
                subscribeOn(Schedulers.io())
                observeOn(AndroidSchedulers.mainThread())
                subscribe {
                    Log.d("Messages", "fiveseconds")
                    MainActivity.showNotification("dummy", "A new notificiation created", R.drawable.baseline_email_24)
                }
            }
        }

        val observable = Observable.just("Hello","Welcome to","Ubaya")

        val observer = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                Log.d("Messages", "begin subscribe")
            }

            override fun onNext(t: String) {
                Log.d("Messages", "data: $t")
            }

            override fun onError(e: Throwable) {
                Log.e("Messages", "error: ${e!!.message.toString()}")
            }

            override fun onComplete() {
                Log.d("Messages", "complete")
            }
        }

        observable.apply {
            subscribeOn(Schedulers.io())
            observeOn(AndroidSchedulers.mainThread())
            subscribe(observer)
        }*/
    }
}