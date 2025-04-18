package com.example.doctors_appointment.data.repository

import com.example.doctors_appointment.data.model.Appointment
import com.example.doctors_appointment.data.model.Doctor
import com.example.doctors_appointment.data.model.Patient

interface FirestoreRepository{

    // DOCTOR
    suspend fun insertDoctor(doctor: Doctor)
    suspend fun deleteDoctor(doctorId: String)
    suspend fun updateDoctor(doctor: Doctor)
    suspend fun getAllDoctors(): List<Doctor>
    suspend fun getDoctorById(doctorId: String): Doctor?
    suspend fun getDoctorsByCategory(category: String): List<Doctor>
    suspend fun auThenticateUserAsDoctor(id: String): Doctor?

    // PATIENT
    suspend fun insertPatient(patient: Patient)
    suspend fun updatePatient(patient: Patient)
    suspend fun deletePatient(patientId: String)
    suspend fun getPatientById(patientId: String): Patient?
    suspend fun auThenticateUserAsPatient(id: String): Patient?

    // APPOINTMENT
    suspend fun insertAppointment(appointment: Appointment)
    suspend fun updateAppointment(appointment: Appointment)
    suspend fun deleteAppointment(appointmentId: String)
    suspend fun getAppointmentById(appointmentId: String): Appointment?
    suspend fun getUpcomingAppointments(userId: String, isDoctor: Boolean): List<Appointment>
    suspend fun getPastAppointments(userId: String, isDoctor: Boolean): List<Appointment>

    // SUPPORT
    suspend fun setAppointment(doctorId: String, patientId: String, appointment: Appointment)
}