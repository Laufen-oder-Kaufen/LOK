package com.example.lok.ui.map

import android.hardware.SensorManager
import android.hardware.SensorEvent
import android.os.Bundle
import android.hardware.SensorEventListener
import android.app.Activity
import android.content.Context
import android.hardware.Sensor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.lok.R
import java.text.DateFormat
import java.util.*

//import androidx.lifecycle.ViewModelProviders
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.example.lok.R
//
//class MapFragment : Fragment() {
//
//    companion object {
//        fun newInstance() = MapFragment()
//    }
//
//    private lateinit var viewModel: MapViewModel
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.map_fragment, container, false)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(MapViewModel::class.java)
//        // TODO: Use the ViewModel
//    }
//
//}

class MapFragment : Fragment(), SensorEventListener {

    private var sensorManager: SensorManager? = null
    private var stepSensor: Sensor? = null
    private var oldSteps: Float = 0.0f
    private var steps: Float = 0.0f
    private var currSteps: Float = 0.0f
    private var hasStarted: Boolean = false
    private var startTime: Date? = Date()
    private var endTime: Date? = Date()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.map_fragment, container, false)
        sensorManager = activity?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        stepSensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        val btn = view.findViewById<Button>(R.id.stepBtn)
        btn.setOnClickListener{
            val button = view?.findViewById<Button>(R.id.schrittzaehler)
            if (!hasStarted) {
                oldSteps = steps
                hasStarted = true
                startTime = Date()
                button?.text = "Stop"
            } else {
                hasStarted = false;
                endTime = Date()
                button?.text = "Start"
            }
        }
        return view
    }

    override fun onSensorChanged(event: SensorEvent) {
        steps = event.values[0]
        if(hasStarted) {
            currSteps = steps - oldSteps
            val counter = view?.findViewById<TextView>(R.id.schrittzaehler)
            counter?.text = currSteps.toInt().toString()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        sensorManager!!.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)
    }
}