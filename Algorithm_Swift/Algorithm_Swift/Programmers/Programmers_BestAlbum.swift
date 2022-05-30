//
//  Programmers_BestAlbum.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/30.
//

import Foundation

func solution(_ genres:[String], _ plays:[Int]) -> [Int] {
    var sum: [String: Int] = [:]
    var genrePlayCount: [String: [(Int,Int)]] = [:]
    for i in 0..<genres.count{
        sum[genres[i], default: 0] += plays[i]
        if genrePlayCount[genres[i]] == nil{
            genrePlayCount[genres[i]] = [(plays[i], i)]
        }else{
            var arr = genrePlayCount[genres[i]]!
            arr = arr.sorted(by: {
                return $0.0 < $1.0
            })
            
            if arr.count == 1{
                arr.append((plays[i], i))
            }else{
                for j in 0..<arr.count{
                    if arr[j].0 < plays[i]{
                        arr[j].0 = plays[i]
                        arr[j].1 = i
                        break
                    }
                }
            }
            genrePlayCount[genres[i]] = arr
        }
    }
    let sumSorted = sum.sorted(by: {
        return $0.1 > $1.1
    })
    var answer: [Int] = []
    for (key, value) in sumSorted{
        let arr = genrePlayCount[key]!.sorted(by:{
            if $0.0 == $1.0{
                return $0.1 < $1.1
            }
            return $0.0 > $1.0
        })
        for i in 0..<arr.count{
            answer.append(arr[i].1)
        }
    }
    return answer
}
