//
//  Programmers_TripRoute.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/27.
//

import Foundation

func Programmers_TripRoute(){
    var ticket: [[String]] = []
    var visit: [Bool] = []
    var answer: [String] = []
    func solution(_ tickets:[[String]]) -> [String] {
        ticket = tickets
        visit = Array(repeating: false, count: ticket.count)
        for i in 0..<tickets.count{
            if tickets[i][0] == "ICN"{
                visit[i] = true
                dfs(1, tickets[i][1], "ICN ")
                visit[i] = false
            }
        }
        answer.sort()
        let list = answer[0].split(separator: " ").map{String($0)}
        return list
    }
    func dfs(_ count: Int, _ now: String, _ str: String){
        if count == ticket.count{
            answer.append(str+now)
            return
        }
        for i in 0..<ticket.count{
            if !visit[i] && ticket[i][0] == now{
                visit[i] = true
                dfs(count+1, ticket[i][1], str+ticket[i][0]+" ")
                visit[i] = false
            }
        }
        
    }
}
