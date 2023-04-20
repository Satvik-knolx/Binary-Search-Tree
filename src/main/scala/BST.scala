package com.knoldus

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

case class Node(var element: Int,
                var leftNode: Node = null,
                var rightNode: Node = null)

class BST {
  private val loggerobj = Logger(getClass)
  private var rootNode: Node = null

  def addNode(element: Int): Node = {3
    rootNode = insertNode(rootNode, element)
    rootNode
  }

  def traversal() {
    def traversalInorder(currentNode: Node): Unit = {
      if (currentNode == null)
        currentNode
      else {
        traversalInorder(currentNode.leftNode)
        println(currentNode.element)
        traversalInorder(currentNode.rightNode)
      }
    }

    traversalInorder(rootNode)
  }

  def deleteNode(element: Int): Node = {
    rootNode = deleteRecur(rootNode: Node, element: Int)
    rootNode
  }

  private def deleteRecur(currentNode: Node, element: Int): Node = {
    if (currentNode == null) {
      loggerobj.info("cannot perform deletion as " + element + " not found")
      currentNode
    } else if (element < currentNode.element) {
      currentNode.leftNode = deleteRecur(currentNode.leftNode, element)
      currentNode
    } else if (element > currentNode.element) {
      currentNode.rightNode = deleteRecur(currentNode.rightNode, element)
      currentNode
    } else {
      if (currentNode.leftNode == null)
        currentNode.rightNode
      else if (currentNode.rightNode == null)
        currentNode.leftNode
      else {
        currentNode.element = minValue(currentNode.rightNode)
        currentNode.rightNode = deleteRecur(currentNode.rightNode, currentNode.element)
        loggerobj.info("deleted: " + element)
        currentNode
      }
    }
  }

  def search(element: Int): Option[Int] = {
    @tailrec
    def searchNode(currentNode: Node, element: Int): Option[Int] = {
      if (currentNode == null) {
        loggerobj.info(element + " not found")
        None
      } else if (currentNode.element == element) {
        loggerobj.info("Found " + element)
        Some(currentNode.element)
      } else if (element < currentNode.element)
        searchNode(currentNode.leftNode, element)
      else
        searchNode(currentNode.rightNode, element)
    }

    searchNode(rootNode, element)
  }

  private def minValue(currentNode: Node): Int = {
    //    var minValue = currentNode.element
    //    var node = currentNode
    //    while (node.leftNode != null) {
    //      minValue = node.leftNode.element
    //      node = node.leftNode
    @tailrec
    def min(currentNode: Node): Int = {
      if (currentNode.leftNode == null)
        currentNode.element
      else
        min(currentNode.leftNode)
    }

    min(currentNode)
  }

  private def insertNode(currentNode: Node, element: Int): Node = {
    if (currentNode == null) {
      loggerobj.info(element + " added")
      Node(element)
    } else if (element < currentNode.element) {
      currentNode.leftNode = insertNode(currentNode.leftNode, element)
      currentNode
    } else {
      currentNode.rightNode = insertNode(currentNode.rightNode, element)
      currentNode
    }
  }
}
