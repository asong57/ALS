//
//  Programmers_NewId.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/04.
//

import Foundation

func solution_newId(_ new_id:String) -> String {
    var lower = new_id.lowercased()
    var id = ""
    for c in lower{
        if !c.isNumber && !c.isLetter && c != "-" && c != "." && c != "_"{
        }else{
            id += String(c)
        }
    }
    while id.contains(".."){
        id = id.replacingOccurrences(of: "..", with: ".")
    }
    if id.first == "."{
        if id.count > 1{
            id = String(id[id.index(id.startIndex, offsetBy: 1)...id.index(id.endIndex, offsetBy: -1)])
        }else{
            id = ""
        }
    }
    if id.last == "."{
        id = String(id[id.index(id.startIndex, offsetBy: 0)...id.index(id.endIndex, offsetBy: -2)])
    }
    if id.count == 0{
        id = "a"
    }
    
    if id.count >= 16{
        id = String(id[id.index(id.startIndex, offsetBy: 0)...id.index(id.startIndex, offsetBy: 14)])
        if id.last == "."{
            id = String(id[id.index(id.startIndex, offsetBy: 0)...id.index(id.endIndex, offsetBy: -2)])
        }
    }
    if id.count > 0{
        while id.count <= 2 {
            if id.count == 1{
                id += String(id.first!)
            }else{
                id += String(id.last!)
            }
        }
    }
    
    return id
}
