//
//  Programmers_PhoneList.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/08.
//

import Foundation

func solution(phone_book: [String]) -> Bool {
    var set: Set<String> = []
    
    for phone in phone_book {
        set.insert(phone)
    }
    
    for phone in phone_book {
        for j in 0..<phone.count-1 {
            let index: String.Index = phone.index(phone.startIndex, offsetBy: j)
            let word = String(phone[...index])
            print(word)
            if set.contains(word){
                return false
            }
        }
    }
    return true
}

// let arr = ["12","123","1235","567","88"]
// print(solution(phone_book: arr))
