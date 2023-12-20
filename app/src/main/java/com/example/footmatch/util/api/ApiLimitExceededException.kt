package com.example.footmatch.util.api

import okhttp3.Response
import java.io.IOException


class ApiLimitExceededException(val timeToWait:Long): IOException("API limit exceeded") {

}