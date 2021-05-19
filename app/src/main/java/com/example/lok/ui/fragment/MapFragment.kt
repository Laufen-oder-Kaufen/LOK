package com.example.lok.ui.fragment

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.map_fragment, container, false)
        sensorManager = activity?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        stepSensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        val btn = view.findViewById<Button>(R.id.stepBtn)
        btn.setOnClickListener{
            oldSteps = steps
        }
        return view
    }

    override fun onSensorChanged(event: SensorEvent) {
        steps = event.values[0]
        currSteps = steps - oldSteps
        val counter = view?.findViewById<TextView>(R.id.schrittzaehler)
        counter?.text = currSteps.toInt().toString()
        // steps enthält die Anzahl der Schritte seit Systemneustart
        // speichern von steps bei Start des Laufens
        // steps - oldSteps = currentSteps
        // if(currentSteps<=10000){ [punkte] = currentSteps/1000 } else { [punkte] = 10 }
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