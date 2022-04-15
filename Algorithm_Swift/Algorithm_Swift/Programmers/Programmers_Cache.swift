//
//  Programmers_Cache.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/15.
//

import Foundation

func solution_Cache(_ cacheSize:Int, _ cities:[String]) -> Int {
    var count = 0
    var arr: [String] = []
    if cacheSize == 0{
        return 5 * cities.count
    }
    for c in cities{
        let city = c.lowercased()
        if arr.contains(city){
            arr.remove(at: arr.firstIndex(of: city)!)
            arr.append(city)
            count += 1
        }else{
            if arr.count > cacheSize - 1{
                arr.removeFirst()
            }
            arr.append(city)
            
            count += 5
        }
    }
    return count
}
