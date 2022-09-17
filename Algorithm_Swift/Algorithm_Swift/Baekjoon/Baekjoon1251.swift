//
//  Baekjoon1251.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/09/17.
//

import Foundation

func BJ1251() {
    let word = readLine()!
    var arr_Number = Array(repeating: 0, count: word.count-1)
    for i in 1..<word.count {
        arr_Number[i-1] = i
    }
    var wordSet: [String] = []
    makeCombination_wordSubstring(word.count, 0, temp: [0,0], start: 0)
    wordSet.sort()
    print(wordSet[0])

    func makeCombination_wordSubstring(_ size: Int, _ current: Int, temp: [Int], start: Int){
        var temp = temp
        if current == 2 {
            let firstSubstringIndex = temp[0]
            let secondSubstringIndex = temp[1]
            var firstWord = ""
            var secondWord = ""
            var thirdWord = ""
            var i = 0
            for w in word {
                if i < firstSubstringIndex {
                    firstWord = String(w) + firstWord
                } else if i < secondSubstringIndex {
                    secondWord = String(w) + secondWord
                } else {
                    thirdWord =  String(w) + thirdWord
                }
                i += 1
            }
            wordSet.append(firstWord+secondWord+thirdWord)
        } else {
            var i = start
            while i < arr_Number.count {
                temp[current] = arr_Number[i]
                makeCombination_wordSubstring(size, current+1, temp: temp, start: i+1)
                i += 1
            }
        }
    }
}
