package com.example.doctors_appointment.ui.booking

import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Today
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.doctors_appointment.MyApp.Companion.doctor
import com.example.doctors_appointment.data.model.Doctor
import com.example.doctors_appointment.ui.patientsUI.BottomNavigationItem
import com.example.doctors_appointment.ui.patientsUI.mainHome.fontInria
import com.example.doctors_appointment.ui.theme.Indigo400
import com.example.doctors_appointment.ui.theme.Indigo50
import com.example.doctors_appointment.ui.theme.Indigo900
import com.example.doctors_appointment.ui.DoctorUI.DoctorViewModel
import com.example.doctors_appointment.ui.patientsUI.viewmodels.BookingViewModel
import com.example.doctors_appointment.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import androidx.compose.foundation.layout.Spacer as Spacer


@Composable
fun DoctorSchedule(
    navController: NavController,
    doctorViewModel: DoctorViewModel,
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Indigo50)
            .padding(bottom = 70.dp)
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item{


            Spacer(modifier = Modifier.size(10.dp))



            Text(
                text = "SCHEDULE APPOINTMENT",
                style = MaterialTheme.typography.headlineLarge,
                fontFamily = fontInria,
                color = Indigo900,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))

            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            val newselectedDate = dateFormat.format(doctorViewModel.selectedDate.value)




            val selectedDate = doctorViewModel.selectedDate.value

            showDatePick(context = LocalContext.current, doctorViewModel)

            val currentDate = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, 0)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }.time

            val selectedDateAdjusted = Calendar.getInstance().apply {
                time = selectedDate
                set(Calendar.HOUR_OF_DAY, 0)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }.time
            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = "Selected Date: $newselectedDate",
                fontFamily = fontInria,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            )


            Spacer(modifier = Modifier.height(20.dp))

            val selectedTabIndex=0

            var selectedSlot by remember {
                mutableIntStateOf(-1)
            }

            Text(
                text = "Morning Slots:",
                fontFamily = fontInria,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Indigo900
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                for (i in 0..2) {
                    Slot(36 * (selectedTabIndex) + i, doctor, selectedSlot, doctorViewModel) {
                        selectedSlot = it
                        navController.navigate(Screen.doctorAppointmentDetails.route)

                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                for (i in 3..5) {
                    Slot(36 * (selectedTabIndex) + i, doctor, selectedSlot, doctorViewModel) {
                        selectedSlot = it
                        navController.navigate(Screen.doctorAppointmentDetails.route)

                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                for (i in 6..8) {
                    Slot(36 * (selectedTabIndex) + i, doctor, selectedSlot, doctorViewModel) {
                        selectedSlot = it
                        navController.navigate(Screen.doctorAppointmentDetails.route)

                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                for (i in 9..11) {
                    Slot(36 * (selectedTabIndex) + i, doctor, selectedSlot, doctorViewModel) {
                        selectedSlot = it
                        navController.navigate(Screen.doctorAppointmentDetails.route)

                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                for (i in 12..14) {
                    Slot(36 * (selectedTabIndex) + i, doctor, selectedSlot, doctorViewModel) {
                        selectedSlot = it
                        navController.navigate(Screen.doctorAppointmentDetails.route)

                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                for (i in 15..17) {
                    Slot(36 * (selectedTabIndex) + i, doctor, selectedSlot, doctorViewModel) {
                        selectedSlot = it
                        navController.navigate(Screen.doctorAppointmentDetails.route)

                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))


            Text(
                text = "Evening Slots:",
                fontFamily = fontInria,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Indigo900
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                for (i in 18..20) {
                    Slot(36 * (selectedTabIndex) + i, doctor, selectedSlot, doctorViewModel) {
                        selectedSlot = it
                        navController.navigate(Screen.doctorAppointmentDetails.route)

                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                for (i in 21..23) {
                    Slot(36 * (selectedTabIndex) + i, doctor, selectedSlot, doctorViewModel) {
                        selectedSlot = it
                        navController.navigate(Screen.doctorAppointmentDetails.route)

                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                for (i in 24..26) {
                    Slot(36 * (selectedTabIndex) + i, doctor, selectedSlot, doctorViewModel) {
                        selectedSlot = it
                        navController.navigate(Screen.doctorAppointmentDetails.route)

                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                for (i in 27..29) {
                    Slot(36 * (selectedTabIndex) + i, doctor, selectedSlot, doctorViewModel) {
                        selectedSlot = it
                        navController.navigate(Screen.doctorAppointmentDetails.route)

                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                for (i in 30..32) {
                    Slot(36 * (selectedTabIndex) + i, doctor, selectedSlot, doctorViewModel) {
                        selectedSlot = it
                        navController.navigate(Screen.doctorAppointmentDetails.route)


                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                for (i in 33..35) {
                    Slot(36 * (selectedTabIndex) + i, doctor, selectedSlot, doctorViewModel) {
                        selectedSlot = it
                        navController.navigate(Screen.doctorAppointmentDetails.route)

                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))


        }



    }
}

@Composable
fun Slot(
    slotNo: Int,
    doctor: Doctor,
    selectedSlot: Int,
    doctorViewModel: DoctorViewModel,
    onSlotSelect: (Int) -> Unit,    // Callback to notify parent when a slot is selected
) {
    Button(
        onClick = {
            if (doctor.availabilityStatus[slotNo]) {
                onSlotSelect(slotNo) // Notify parent about the selection
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (slotNo == selectedSlot) Indigo400 else Color.White,
            contentColor = if (doctor.availabilityStatus[slotNo]) {
                if (selectedSlot == slotNo) Color.White else Indigo900
            } else Color.LightGray,
        )
    ) { val time= doctorViewModel.getTime(slotNo%36);

        Text(
            text =String.format("%.2f",time)
        )
    }
}



@Composable
fun showDatePick(context: Context, doctorViewModel: DoctorViewModel) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val selectedDate = remember { mutableStateOf(Date()) }
    val datePickerDialog = android.app.DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            val selectedCalendar = Calendar.getInstance()
            selectedCalendar.set(year, month, dayOfMonth)
            selectedDate.value = selectedCalendar.time
        }, year, month, day
    )

    Button(onClick = { datePickerDialog.show() }) {
        Text(text = "Open Date Picker")
    }

    doctorViewModel.selectedDate =  selectedDate
}