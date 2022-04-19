//
//  Programmers_RoadGame.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/19.
//

import Foundation

var answer: [[Int]] = []
func solution_RoadGame(_ nodeinfo:[[Int]]) -> [[Int]] {
    var nodeList: [Node] = []
    for i in 0..<nodeinfo.count{
        nodeList.append(Node(i+1,nodeinfo[i][0], nodeinfo[i][1]))
    }
    nodeList = nodeList.sorted{ $0.y > $1.y}
    var root = nodeList[0]
    for i in 1..<nodeList.count{
        let child = nodeList[i]
        createNode(root, child)
    }
    answer = Array(repeating: [], count: 2)
    preorder(root)
    postorder(root)
    return answer
}
func createNode(_ root: Node, _ child: Node){
    if root.x > child.x{
        if root.left == nil{
            root.left = child
        }else{
            createNode(root.left!, child)
        }
    }else{
        if root.right == nil{
            root.right = child
        }else{
            createNode(root.right!, child)
        }
    }
}
func preorder(_ root: Node){
    answer[0].append(root.id)
    if root.left != nil{
        preorder(root.left!)
    }
    if root.right != nil{
        preorder(root.right!)
    }
}
func postorder(_ root: Node){
    if root.left != nil{
        postorder(root.left!)
    }
    if root.right != nil{
        postorder(root.right!)
    }
    answer[1].append(root.id)
}
class Node{
    let id: Int
    let x: Int
    let y: Int
    var left: Node?
    var right: Node?
    init(_ id: Int, _ x: Int, _ y: Int){
        self.id = id
        self.x = x
        self.y = y
        self.left = nil
        self.right = nil
    }
}
