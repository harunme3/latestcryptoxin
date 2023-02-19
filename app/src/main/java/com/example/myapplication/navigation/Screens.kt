package com.example.myapplication.navigation

sealed class Screens(val route:String){
    object DashBoard: Screens("dashboard_route")
    object Home: Screens("home_route")
    object Follow: Screens("follow_route")
    object Tox: Screens("tox_route")
    object Profile: Screens("profile_route")
    object Wallet: Screens("wallet_route")
    object SplashScreen: Screens("splash_route")
    object CreateImport: Screens("createImport_route")
    object CreateAccount: Screens("createAccount_route")
    object VerifyAccount: Screens("verifyAccount_route")
    object ImportAccount: Screens("importAccount_route")
    object EditProfile:Screens("editProfile_route")
    object ReferralScreen:Screens("referral_route")
    object ReferralPatternScreen:Screens("referralPattern_route")
    object MandatoryDetails:Screens("mandatoryDetails_route")
    object FollowerScreen:Screens("followerScreen_route")
    object FollowingScreen:Screens("followingScreen_route")
    object ReferralDashboardScreen:Screens("referralDashboardScreen_route")
    object DailyCheckInDashboardScreen:Screens("DailyCheckInDashboardScreen_route")
    object CreateCommentScreen:Screens("createCommentScreen_route")
    object ViewPostDetailsScreen:Screens("viewPostDetailsScreen_route")
    object ViewPostScreen:Screens("viewPostScreen_route")
    object CinSendScreen:Screens("cinSendScreen_route")
    object CinReceiveScreen:Screens("cinReceiveScreen_route")
    object PrivateKeyScreen:Screens("privateKeyScreen_route")
    object ProfileImageUpdateScreen:Screens("profileImageUpdateScreen_route")
    object DoneScreen:Screens("doneScreen_route")
    object ReferralTreeDataScreen:Screens("referralTreeDataScreen_route")
    object AboutUsScreen:Screens("aboutUsScreen_route")
    object AirDropScreen:Screens("airDropScreen_route")
}
