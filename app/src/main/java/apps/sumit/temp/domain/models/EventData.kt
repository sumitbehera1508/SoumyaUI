package apps.sumit.temp.domain.models

import android.net.Uri

data class EventData(
    var name: String? = null,
    var registrationNumber: String? = null,
    var branch: String? = null,
    var iCard: Uri? = null,
    var email: String? = null,
    var gender: String? = null,
    var dateOfBirth: String? = null,
    var typeOfEvent: String? = null,
    var startDate: String? = null,
    var endDate: String? = null,
    var location: String? = null,
    var eventProof: Uri? = null,
    var billImage: Uri? = null,
    var signature: Uri? = null,
) {
    fun isComplete(): Boolean {
        when (true) {
            name.isNullOrBlank() -> return false
            registrationNumber.isNullOrBlank() -> return false
            branch.isNullOrBlank() -> return false
            (iCard == null) -> return false
            email.isNullOrBlank() -> return false
            gender.isNullOrBlank() -> return false
            dateOfBirth.isNullOrBlank() -> return false
            typeOfEvent.isNullOrBlank() -> return false
            startDate.isNullOrBlank() -> return false
            endDate.isNullOrBlank() -> return false
            location.isNullOrBlank() -> return false
            (eventProof == null) -> return false
            (billImage == null) -> return false
            (signature == null) -> return false
            else -> {
                return true
            }
        }
       
    }
}
