/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.hyperledger.besu.ethereum.api.jsonrpc.internal.processor;

import org.hyperledger.besu.ethereum.core.Transaction;
import org.hyperledger.besu.ethereum.debug.TraceFrame;
import org.hyperledger.besu.ethereum.mainnet.TransactionProcessor.Result;

import java.util.List;
import java.util.Optional;

public class TransactionTrace {

  private final Transaction transaction;
  private final Result result;
  private final List<TraceFrame> traceFrames;
  private final Optional<Long> time;

  public TransactionTrace(
      final Transaction transaction, final Result result, final List<TraceFrame> traceFrames) {
    this.transaction = transaction;
    this.result = result;
    this.traceFrames = traceFrames;
    this.time = Optional.empty();
  }

  public TransactionTrace(
      final Transaction transaction,
      final Result result,
      final List<TraceFrame> traceFrames,
      final Long time) {
    this.transaction = transaction;
    this.result = result;
    this.traceFrames = traceFrames;
    this.time = Optional.of(time);
  }

  public Transaction getTransaction() {
    return transaction;
  }

  public long getGas() {
    return transaction.getGasLimit() - result.getGasRemaining();
  }

  public long getGasLimit() {
    return transaction.getGasLimit();
  }

  public Result getResult() {
    return result;
  }

  public List<TraceFrame> getTraceFrames() {
    return traceFrames;
  }

  public Optional<Long> getTime() {
    return time;
  }
}
