//
//  Baekjoon2920.swift
//  Algorithm_Swift
//
//  Created by asong on 2021/12/06.
//
import Foundation

func BJ2920(){
    let line = readLine()
    if line!.elementsEqual("1 2 3 4 5 6 7 8") {
        print("ascending")
    }else if line!.elementsEqual("8 7 6 5 4 3 2 1") {
        print("descending")
    }else{
        print("mixed")
    }
}
