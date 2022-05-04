//
//  Programmers_CandidateKey.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/04.
//

import Foundation

func Programmers_CandidateKey(){
    var arr: [Int] = []
    var keySet: Set<[Int]> = Set<[Int]>()
    var answer = 0
    var relations: [[String]] = []
    func solution(_ relation:[[String]]) -> Int {
        relations = relation
        for i in 0..<relation[0].count{
            arr.append(i)
        }
        for i in 1...relation[0].count{
            var temp = Array(repeating: 0, count: i)
            makeCombination(0,0,temp)
        }
        return answer
    }
    func makeCombination(_ current: Int, _ start: Int, _ temp: [Int]){
        var temp = temp
        if temp.count == current{
            checkRelation(temp)
        }else{
            var i = start
            while i < arr.count{
                temp[current] = arr[i]
                makeCombination(current+1, i+1, temp)
                i += 1
            }
        }
    }
    func checkRelation(_ temp: [Int]){
        for keyArr in keySet{
            var count = 0
            for n in keyArr{
                if temp.contains(n){
                    count += 1
                }else{
                    break
                }
            }
            if count == keyArr.count{
                return
            }
        }
        var set: Set<String> = Set<String>()
        for i in 0..<relations.count{
            var str = ""
            for j in 0..<temp.count{
                str += relations[i][temp[j]]
            }
            if !set.contains(str){
                set.insert(str)
            }else{
                return
            }
        }
        
        keySet.insert(temp)
        answer += 1
    }
}
