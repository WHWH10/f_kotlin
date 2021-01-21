package com.example.myapplication.안드로이드_Essential

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRealmBinding
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRealmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealmBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Realm 사용법
        // Builder() : Method Chaining(메소드 체이닝) - 계속 연결해서 가져가는 것 ~~.~~~.~~. 이런식
        Realm.init(this@RealmActivity)
        val config: RealmConfiguration =
            RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)

        // Realm 얻는법
        val realm = Realm.getDefaultInstance()

        binding.realmSave.setOnClickListener {
            realm.executeTransaction {
                // A 테이블에서 데이터를 가져온다
                // B 테이블에서 데이터를 가져온다
                // C 테이블에서 데이터를 가져온다
                // 조합을 한다
                // D 테이블에 저장을 한다
                with(it.createObject(School::class.java)) {
                    this.name = "어떤 대학교"
                    this.location = "대구광역시"
                }
            }
        }
        binding.realmLoad.setOnClickListener {
            realm.executeTransaction {
              val data =  it.where(School::class.java).findFirst()
                binding.realmData.text = data.toString()
            }
        }
        binding.realmDelete.setOnClickListener {
            realm.executeTransaction{
                it.where(School::class.java).findAll().deleteAllFromRealm()
            }
        }
    }
}