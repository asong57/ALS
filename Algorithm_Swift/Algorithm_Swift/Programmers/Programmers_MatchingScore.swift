//
//  Programmers_MatchingScore.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/04.
//

import Foundation

var matchingScore: [Int:Int] = [:]
var urlDict: [String:Int] = [:]
var outScore: [Int:Int] = [:]
var urlScore: [Int:[Int]] = [:]
func solution(_ word:String, _ pages:[String]) -> Int {
    checkMatching(pages, word)
    checkOutLink(pages)
    var max: Double = 0
    var answer = 0
    for i in 0..<pages.count{
        var sum: Double = Double(matchingScore[i]!)
        if let arr = urlScore[i] {
            for k in 0..<arr.count{
                if matchingScore[i] != nil && outScore[arr[k]] != nil{
                    sum += Double(matchingScore[arr[k]]!) / Double(outScore[arr[k]]!)
                }
            }
        }
        if max < sum{
            max = sum
            answer = i
        }
    }
    return answer
}
func checkMatching(_ pages: [String], _ word: String){
    var word = word.lowercased()
    for i in 0..<pages.count{
        var page = pages[i].lowercased()
        var count = 0
        var w = ""
        for c in page{
            if c.isLetter{
                w += String(c)
            }else{
                if w == word{
                    count += 1
                }
                 w = ""
            }
        }
        matchingScore[i] = count
        let urls = page.components(separatedBy: "<meta property=\"og:url\" content=\"")
        let url = urls[1].split(separator: "\"").map{String($0)}
        urlDict[url[0]] = i
    }
}
func checkOutLink(_ pages: [String]){
    for i in 0..<pages.count{
        var page = pages[i].lowercased()
        let urls = page.components(separatedBy: "<a href=\"")
        var count = 0
        for j in 1..<urls.count{
            count += 1
            let ss = urls[j].split(separator: "\"").map{String($0)}
            if let url = urlDict[ss[0]] {
                if urlScore[url] == nil{
                    urlScore[url] = [i]
                }else{
                    var arr = urlScore[url]!
                    arr.append(i)
                    urlScore[url] = arr
                }
            }
            
        }
        outScore[i] = count
    }
}
