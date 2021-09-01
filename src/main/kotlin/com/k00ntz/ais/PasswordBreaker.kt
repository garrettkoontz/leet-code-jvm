package com.k00ntz.ais

import khttp.post

//curl 'https://hack.ainfosec.com/challenge/submit-answer/'
//-H 'authority: hack.ainfosec.com' -H 'accept: application/json, text/javascript, */*; q=0.01'
//-H 'origin: https://hack.ainfosec.com' -H 'x-requested-with: XMLHttpRequest'
//-H 'user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36'
//-H 'dnt: 1' -H 'content-type: application/x-www-form-urlencoded; charset=UTF-8'
//-H 'sec-fetch-site: same-origin' -H 'sec-fetch-mode: cors' -H 'referer: https://hack.ainfosec.com/'
//-H 'accept-encoding: gzip, deflate, br' -H 'accept-language: en-US,en;q=0.9'
//-H 'cookie: csrftoken=4xY2lUXdUVBuZrT9Xwzm2xMUhZ9oYUmvOkyJYk46aPKbHEUz1eQ9HQDWEsod7MGg; sessionid=6n3refk4mm2rcjdkgkmdtlpogao41163'
//--data 'csrfmiddlewaretoken=kG90ODSR1Q4iMdALW0NrXBtcZtlO2VPH4tJHr3ZKhKdZuqBb0I4eCUkemWADbN9s&challenge_id=code_breaker&answer=AAAAAAA'
//--compressed

fun main(){
    val resp = post("https://hack.ainfosec.com/challenge/submit-answer/",
        headers = mapOf("user-agent" to "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36"),
        data = "csrfmiddlewaretoken=kG90ODSR1Q4iMdALW0NrXBtcZtlO2VPH4tJHr3ZKhKdZuqBb0I4eCUkemWADbN9s&challenge_id=code_breaker&answer=AAAAAAA",
        cookies = mapOf("csrftoken" to "4xY2lUXdUVBuZrT9Xwzm2xMUhZ9oYUmvOkyJYk46aPKbHEUz1eQ9HQDWEsod7MGg", "sessionid" to "6n3refk4mm2rcjdkgkmdtlpogao41163"))
    println(resp.text)
}