package com.nastynick.billdivider.presentation.service

import android.app.Activity
import android.location.Address
import android.location.Geocoder
import android.location.Location
import com.google.android.gms.location.LocationServices
import io.reactivex.Single
import java.util.*

class LocationService constructor(private val activity: Activity) {

    fun getLocation(): Single<Address> {
        return Single.create<Address> { emitter ->
            LocationServices
                    .getFusedLocationProviderClient(activity)
                    ?.lastLocation
                    ?.addOnSuccessListener(activity) { location: Location ->
                        val address = Geocoder(activity, Locale.getDefault())
                                .getFromLocation(location.latitude, location.longitude, 1)[0]

                        if (address != null) {
                            emitter.onSuccess(address)
                        }
                    }
        }
    }
}