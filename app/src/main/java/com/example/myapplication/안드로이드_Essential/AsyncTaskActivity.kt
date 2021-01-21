package com.example.myapplication.안드로이드_Essential

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAsyncTaskBinding
import java.lang.Exception

class AsyncTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAsyncTaskBinding

    var task: BackgroundAsyncTask ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAsyncTaskBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.start.setOnClickListener {
            task = BackgroundAsyncTask(binding.progressbar, binding.ment)
            task?.execute()
        }

        binding.stop.setOnClickListener {
//            task?.cancel(true)
            startActivity(Intent(this, PhoneBookActivity::class.java))
        }
    }

    // activity 벗얼날때 정지시키고 싶을 때 라이프 사이클에 따로 asyncTask 정지하는 코드 넣어야 함
    override fun onPause() {
        task?.cancel(true)
        super.onPause()
    }
}

class BackgroundAsyncTask(
    val progressBar: ProgressBar,
    val progressText: TextView
) : AsyncTask<Int, Int, Int>() {
    // params : doInBackground 사용할 타입
    // progress: onProgressUpdate 사용할 타입
    // result : onPostExecute 사용할 타입

    var percent: Int = 0

    override fun onPreExecute() {
        percent = 0
        progressBar.progress = percent
    }

    //가변 인자 vararg : 선언된 타입의 값을 쉼표(,)로 구분해서 복수 개를 전달할 수 있다. 파라미터는 temp[0]과 같이 배열처럼 사용할 수 있다
    override fun doInBackground(vararg params: Int?): Int {
        // isCancelled 초기값은 true 시스템에 설정되어있다
        // !isCancelled -> isCancelled == false
        while (!isCancelled) {
            percent++
            Log.d("async_percent", "percent :: $percent")
            if (percent > 100) {
                break
            } else {
                publishProgress(percent)
            }
            try {
                Thread.sleep(100)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return percent
    }

    //doInBackground( ) 메서드 안에서 publishProgress( ) 메서드가 호출되면 실행
    override fun onProgressUpdate(vararg values: Int?) {
//        super.onProgressUpdate(*values)
        progressBar.progress = values[0] ?: 0
        progressText.text = "퍼센트 : ${values[0]}"
    }

    override fun onPostExecute(result: Int?) {
//        super.onPostExecute(result)
        progressText.text = "작업이 완료되었습니다"
    }

    // 취소버튼 눌렀을 떄
    override fun onCancelled() {
//        super.onCancelled()
        progressBar.progress = 0
        progressText.text = "작업이 취소되었습니다"
    }
}