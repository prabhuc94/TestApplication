package app.codechallenge.testapplication.presentation.state

data class InfoListState(
    val isLoading : Boolean = false,
    val infos : List<String>? = null,
    val error : String = ""
)
