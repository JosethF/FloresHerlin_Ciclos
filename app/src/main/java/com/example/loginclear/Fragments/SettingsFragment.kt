package com.example.loginclear.Fragments


import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.loginclear.R
import java.util.*

class SettingsFragment : Fragment(), AdapterView.OnItemSelectedListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        //The spinner is created and collects the data from the string file
        val spinner: Spinner = view.findViewById(R.id.spinnerLanguage)
        val adapter: ArrayAdapter<CharSequence>? = context?.let { ArrayAdapter.createFromResource(it,R.array.selectedLanguage, android.R.layout.simple_spinner_item) }
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
        return view
    }

    //THIS FUNCTION IS IN CHARGE OF CHANGING THE LANGUAGE OF THE APP WITH THE PARAMETERIZED CODE
    private fun setAppLocale(localeCode: String) {
        val resources: Resources = resources
        val dm: DisplayMetrics = resources.getDisplayMetrics()
        val config: Configuration = resources.getConfiguration()
        config.setLocale(Locale(localeCode.lowercase(Locale.getDefault())))

        resources.updateConfiguration(config, dm)
    }

    //THE NAME OF THE ITEM CLICKED IN THE SPINNER IS COLLECTED
    override fun onItemSelected(parent: AdapterView<*>?, View: View?, position: Int, id: Long) {
        val text = parent?.getItemAtPosition(position).toString()
        Toast.makeText(parent?.context,text,Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}

}