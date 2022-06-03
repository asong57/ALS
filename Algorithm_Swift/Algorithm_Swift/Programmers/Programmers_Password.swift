//
//  Programmers_Password.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/03.
//

import Foundation

func solution_Password(_ s:String, _ n:Int) -> String {
    let arr = ["a", "b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    var str = ""
    for c in s{
        if c == " "{
            str += " "
        }else{
            for i in 0..<arr.count{
                let ch = Character(extendedGraphemeClusterLiteral:c)
                if ch.isLowercase {
                    if arr[i] == String(c){
                    var index = i + n
                    str += arr[index%arr.count]
                    }
                }else{
                    if arr[i] == String(c).lowercased(){
                    var index = i + n
                    str += arr[index%arr.count].uppercased()
                    }
                }
                
            }
        }
    }
    return str
}
