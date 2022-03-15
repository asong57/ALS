//
//  Programmers_MenuRenewal.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/15.
//

import Foundation

var dict: [Int: [String]] = [:]
var dict2: [String: Int] = [:]
func solution(_ orders:[String], _ course:[Int]) -> [String] {
    var j = 1
    for i in 0..<orders.count-1 {
        j = i + 1
        var str = orders[i]
        var arr: [String] = []
        while j < orders.count{
            arr = []
            var str2 = orders[j]
            for s in str{
                for ss in str2{
                    if s == ss{
                        arr.append(String(s))
                    }
                }
            }
            var k = course.count-1
            while k >= 0{
                if course[k] <= arr.count {
                    let temp = Array(repeating: "", count: course[k])
                    makeCombination(arr, temp, 0,0,course[k])
                }
                k -= 1
            }
            j += 1
        }
    }
    var result: [String] = []
    for i in course{
        if dict[i] != nil {
            var arr = dict[i]!
            var answer: [String] = []
            var max = 0
            for str in arr{
                if max < dict2[str]!{
                    answer.removeAll()
                    answer.append(str)
                    max = dict2[str]!
                }else if max == dict2[str]!{
                    answer.append(str)
                }
            }
            if answer.count > 0{
                result.append(contentsOf: answer)
            }
        }
    }
    result.sort()
    return result
}

func makeCombination(_ arr: [String],_ temps: [String], _ count: Int, _ start: Int, _ k: Int){
    var temp = temps
    if count == k {
        var str = ""
        temp.sort()
        for s in temp {
            str += s
        }
        if dict2[str] == nil{
            dict2[str] = 1
        }else{
            dict2[str] = dict2[str]! + 1
        }
        if dict[k] == nil {
            var array: [String] = []
            array.append(str)
            dict[k] = array
        }else{
            var array = dict[k]!
            if !array.contains(str){
                array.append(str)
                dict[k] = array
            }
        }
    }else{
        var i = start
        while i < arr.count {
            temp[count] = arr[i]
            makeCombination(arr, temp, count+1, i+1, k)
            i += 1
        }
    }
}
