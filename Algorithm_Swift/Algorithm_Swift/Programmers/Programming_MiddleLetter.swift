//
//  Programming_MiddleLetter.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/13.
//

import Foundation

func solution(_ s:String) -> String {
    let index = s.count / 2
    if s.count % 2 == 0{
        return String(s[s.index(s.startIndex, offsetBy: index-1)...s.index(s.startIndex, offsetBy: index)])
    }else{
        return String(s[s.index(s.startIndex, offsetBy: index)])
    }
    return ""
}
