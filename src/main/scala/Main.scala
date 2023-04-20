package com.knoldus

object Main extends App {

  private val bst = new BST
  bst.addNode(12)
  bst.addNode(6)
  bst.addNode(15)
  bst.addNode(9)
  bst.addNode(10)
  bst.addNode(8)
  bst.addNode(4)
  bst.addNode(5)
  bst.addNode(3)
  bst.addNode(14)
  bst.addNode(16)
  bst.traversal()

  bst.deleteNode(6)
  bst.deleteNode(13)
  bst.traversal()
  bst.search(12)
  bst.search(6)

}