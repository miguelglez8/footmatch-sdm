package com.example.footmatch.util.api

import okhttp3.Response



class ApiLimitExceededException(val timeToWait:Long): Exception("API limit exceeded") {

}