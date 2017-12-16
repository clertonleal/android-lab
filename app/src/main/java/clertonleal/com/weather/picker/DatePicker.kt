package clertonleal.com.weather.picker

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.app.DatePickerDialog
import android.widget.DatePicker
import java.util.*


class DatePicker : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity, this, year, month, day)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}