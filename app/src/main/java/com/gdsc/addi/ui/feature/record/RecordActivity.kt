package com.gdsc.addi.ui.feature.record

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import com.gdsc.addi.ui.theme.AddiTheme
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val REQUEST_RECORD_AUDIO_PERMISSION = 200

@AndroidEntryPoint
class RecordActivity : ComponentActivity() {
    private val viewModel: RecordViewModel by viewModels()

    private var fileName: String = ""

    private var recorder: MediaRecorder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fileName = "${externalCacheDir!!.absolutePath}/audiorecordtest.3gp"

        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION)

        setContent {
            AddiTheme {
                RecordScreen(
                    viewModel = viewModel,
                    onRecord = ::onRecord,
                    onClick = ::goToDone
                )
            }
        }
    }

    private fun goToDone() {
        startActivity(Intent(this, RecordDoneActivity::class.java))
        finish()
    }

    // Requesting permission to RECORD_AUDIO
    private var permissionToRecordAccepted = false
    private var permissions: Array<String> = arrayOf(Manifest.permission.RECORD_AUDIO)

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionToRecordAccepted = if (requestCode == REQUEST_RECORD_AUDIO_PERMISSION) {
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        } else {
            false
        }
        if (!permissionToRecordAccepted) finish()
    }

    private fun onRecord(start: Boolean) = if (start) {
        startRecording()
    } else {
        stopRecording()
    }

    private fun startRecording() {
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_MUSIC)
        val audioName = SimpleDateFormat("yyMMdd_HHmmss", Locale.KOREA).format(Date())
        fileName = "${storageDir?.absolutePath}/${audioName}.3gp"

        recorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            setOutputFile(fileName)
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

            try {
                prepare()
            } catch (e: IOException) {
                Log.e("asdf", "prepare() failed")
            }

            start()
        }
    }

    /** 지금 재녹음하면 계속 쌓이는데 나중에 버튼 눌렀을 때 add하는 걸로 바꾸기 */
    private fun stopRecording() {
        recorder?.apply {
            Log.i("asdf", fileName)
            stop()
            release()
        }
        val audioUri = Uri.parse(fileName)
        viewModel.addRecord(audioUri)
        recorder = null
    }

    override fun onStop() {
        super.onStop()
        recorder?.release()
        recorder = null
    }
}
