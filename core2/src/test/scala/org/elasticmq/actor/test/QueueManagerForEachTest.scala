package org.elasticmq.actor.test

import org.scalatest.{Suite, BeforeAndAfterEach}
import akka.actor.{Props, ActorSystem, ActorRef}
import org.elasticmq.actor.QueueManagerActor

trait QueueManagerForEachTest extends BeforeAndAfterEach {
  this: Suite =>

  val system: ActorSystem

  var queueManagerActor: ActorRef = _

  override protected def beforeEach() {
    super.beforeEach()
    queueManagerActor = system.actorOf(Props[QueueManagerActor])
  }

  override protected def afterEach() {
    system.stop(queueManagerActor)
    super.afterEach()
  }
}