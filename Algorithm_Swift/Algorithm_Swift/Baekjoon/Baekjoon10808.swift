//
//  Baekjoon10808.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/01/06.
//

import Foundation

func BJ10808(){
    let str = readLine()!.map{ String($0) }
    var arr: [Int] = [Int](repeating: 0, count: 26)
    for i in str {
        var index: Int = Int(UnicodeScalar(i)!.value) - 97 ?? 0
        arr[index] = arr[index]+1
    }

    var answer: String = ""

    arr.enumerated().forEach {
        answer = answer+String($1)+" "
    }
    print(answer)
}

func BJplus(){
    let input = readLine()!
    var alphabetCount = [Int](repeating: 0, count: 26)
    for alphabet in input.utf16 {
        let index = Int(alphabet - 97)
        alphabetCount[index] += 1
    }
    for count in alphabetCount {
        print(count, terminator: " ")
    }
}
