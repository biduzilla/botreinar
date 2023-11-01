package com.ricky.botreinar.common

class Utils {
    companion object{
        fun formatTime(seconds: Long): String {
            val minutes = seconds / 60
            val remainingSeconds = seconds % 60
            return String.format("%02d:%02d", minutes, remainingSeconds)
        }
    }

}