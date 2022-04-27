//
//  Programmers_FileSort.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/27.
//

import Foundation

func solution_FileSort(_ files:[String]) -> [String] {
    var arr: [File] = []
    for i in 0..<files.count{
        var head = ""
        var n = ""
        var check = false
        var file = files[i].lowercased()
        for j in file{
            if !j.isNumber && !check{
                head += String(j)
            }else if j.isNumber{
                n += String(j)
                check = true
            }else if !j.isNumber && check{
                break
            }
        }
        arr.append(File(i, head, Int(n)!))
    }
    arr = arr.sorted(by: {
        if $0.head == $1.head{
            if $0.num == $1.num{
                return $0.id < $1.id
            }
            return $0.num < $1.num
        }
        return $0.head < $1.head
    })
    var answer: [String] = []
    for i in 0..<arr.count{
        answer.append(files[arr[i].id])
    }
    return answer
}
class File{
    let id: Int
    let head: String
    let num: Int
    init(_ id: Int, _ head: String, _ num: Int){
        self.id = id
        self.head = head
        self.num = num
    }
}
