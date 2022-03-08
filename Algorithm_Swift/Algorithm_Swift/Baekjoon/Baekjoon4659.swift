//
//  Baekjoon4659.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/08.
//

import Foundation

func BJ4659(){
    var str = readLine()!
    let arr = ["a","e","i","o","u"]
    var vowelCount: Int
    var conCount: Int
    var repeatCount: Int
    var sameStr: String
    var vowelCheck: Bool
    var answer: Bool

    while str != "end" {
        vowelCount = 0
        conCount = 0
        repeatCount = 0
        sameStr = "3"
        vowelCheck = false
        answer = true
        for char in str {
            let c = String(char)
            if arr.contains(c) {
                vowelCheck = true
               vowelCount += 1
                conCount = 0
            }else{
                conCount += 1
                vowelCount = 0
            }
            if sameStr == c && (sameStr != "e" && sameStr != "o"){
                answer = false
            }
            sameStr = c
            if vowelCount >= 3 {
                answer = false
            }
            if conCount >= 3 {
                answer = false
            }
        }

        if vowelCheck != true {
            answer = false
        }
        if answer {
            print("<\(str)> is acceptable.")
        }else{
            print("<\(str)> is not acceptable.")
        }
        str = readLine()!
    }
}

// joined, filter 사용
func BJ4659plus(){
    while true {
        var input = Array(readLine()!).map{String($0)}
        if input.joined() == "end" { break }
        
        if chkPassword(password: input) {
            print("<\(input.joined())> is acceptable.")
        } else {
            print("<\(input.joined())> is not acceptable.")
        }
    }
}
func chkPassword(password: [String]) -> Bool {
    let vowel = ["a","e","i","o","u"]
    if password.filter { vowel.contains($0)}.isEmpty { return false }
    var isVowel = vowel.contains(password.first!)
    
    for i in 0..<password.count {
        if i+1 >= password.count { break }
        let str = password[i...i+1].map{String($0)}
        if str[0] == str[1] {
            if str.joined() == "ee" || str.joined() == "oo" { continue }
            else {
                return false
            }
        }
    }
    
    for i in 0..<password.count {
        if i+2 >= password.count { break }
        let str = password[i...i+2].map{String($0)}
        if str.filter { !vowel.contains($0) }.isEmpty { return false }
        if str.filter { !vowel.contains($0) }.count == 3 { return false }
    }
    return true
}
