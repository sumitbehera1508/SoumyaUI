package apps.sumit.temp.util

data class DropDownData(
    val branchList: List<String> = listOf("MCA", "CSE"),
    val genderList: List<String> = listOf("Male", "Female", "Non binary"),
    val eventTypeList: List<String> = listOf("one day", "dummy"),
)
