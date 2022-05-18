//
//  Financial_P2.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/18.
//

import Foundation

var roadLength: [[Int]] = []
var connectCity: [[Int]] = []
var car:[(Int,Int)] = [(Int,Int)]()
func Financial_P2(cities: [String], roads: [String], cars: [String], customers:[String]){
    let n = cities.count
    roadLength = Array(repeating:Array(repeating:-1, count:cities.count+1), count: cities.count+1)
    connectCity = Array(repeating: [], count: cities.count+1)
    car = Array(repeating: (10001,10001), count: cities.count+1)
    for i in 0..<roads.count{
        let strs = roads[i].split(separator: " ").map{String($0)}
        var a = 0
        var b = 0
        for j in 0..<cities.count{
            if cities[j] == strs[0]{
                a = j
            }
            if cities[j] == strs[1]{
                b = j
            }
        }
        roadLength[b][a] = Int(strs[2])!
        roadLength[a][b] = Int(strs[2])!
        connectCity[a].append(b)
        connectCity[b].append(a)
    }
    for i in 0..<cars.count{
        let strs = cars[i].split(separator: " ").map{String($0)}
        var a = 0
        var b = Int(strs[1])!
        var c = Int(strs[2])!
        for j in 0..<cities.count{
            if cities[j] == strs[0]{
                a = j
                if car[j].0 > b{
                    car[j] = (b,c)
                }
                break
            }
        }
    }
    var answer:[String] = []
    for i in 0..<customers.count{
        let strs = customers[i].split(separator: " ").map{String($0)}
        var a = 0
        var b = 0
        var f = Int(strs[2])!
        for j in 0..<cities.count{
            if cities[j] == strs[0]{
                a = j
            }
            if cities[j] == strs[1]{
                b = j
            }
        }
        
        let intMax = 200 * 100000 + 1;
        var arrA = Array(repeating: intMax, count: n+1)
        arrA = dijkstra_Road(a, arrA)
        var arrB = Array(repeating: intMax, count: n+1)
        arrB = dijkstra_Road(b, arrB)
        
        var check = Int.max
        var answerIndex = -1
        for i in 0..<n{
            if car[i].0 < f{
                continue
            }
            var sum = (arrA[i]+arrB[a]) * car[i].1
            
            if arrA[i] == 0{
                sum = arrB[a] * car[i].1
            }
            if check > sum{
                check = sum
                answerIndex = i
            }
        }
        answer.append(cities[answerIndex])
    }
    print(answer)
}
func dijkstra_Road(_ n: Int, _ arr: [Int]) -> [Int]{
    var cost = arr
    var q: [(Int, Int)] = [(Int,Int)]()
    q.append((n, 0))
    cost[n] = 0
    
    while q.count > 0{
        q = q.sorted{ $0.1 < $1.1}
        var now = q.removeFirst()
        let nIndex = now.0
        let nCost = now.1
        
        if cost[nIndex] < nCost{
            continue
        }
        
        l: for i in 0..<roadLength[nIndex].count{
            let iCost = cost[i]
            if roadLength[nIndex][i] == -1{
                continue l
            }
            if iCost > cost[nIndex] + roadLength[nIndex][i]{
                cost[i] = cost[nIndex] + roadLength[nIndex][i]
                q.append((i, cost[i]))
            }
        }
    }
    return cost
}
let cities = ["a","b","c"]
let roads = ["a b 1", "a c 1", "b c 1"]
let cars = ["a 100 10", "b 300 20", "c 50 4"]
var customers = ["a b 100", "a b 30", "c a 250"]

let cities2 = ["a","b","c","d","e","f","g"]
let roads2 = ["a b 1", "a c 1","c d 3", "b d 5", "b e 6","d e 2","f g 8"]
let cars2 = ["a 100 10","a 200 15", "b 100 5", "c 20 2", " c 300 30", "d 200 20", "d 200 20", "d 500 100", "f 300 50", "g 100 40"]
let customers2 = ["g f 200", "c e 50", "d a 500" ,"a b 50"]
Financial_P2(cities: cities, roads: roads, cars: cars, customers: customers)
