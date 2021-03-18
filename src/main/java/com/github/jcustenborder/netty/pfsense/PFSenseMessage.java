/**
 * Copyright © 2018 Jeremy Custenborder (jcustenborder@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jcustenborder.netty.pfsense;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jcustenborder.netty.syslog.Message;
import com.github.jcustenborder.netty.syslog.Nullable;
import com.github.jcustenborder.netty.syslog.RFC3164Message;

import java.util.Date;

public interface PFSenseMessage extends Message {

  /**
   * Rule number in the pf Ruleset
   * @return
   */
  @Nullable
  @Index(0)
  @JsonProperty("rule-number")
  Integer ruleNumber();

  /**
   * Sub rule number in the pf Ruleset (not typically significant for general use)
   * @return
   */
  @Nullable
  @Index(1)
  @JsonProperty("sub-rule-number")
  String subRuleNumber();

  /**
   * Anchor name in which the rule exists
   * @return
   */
  @Nullable
  @Index(2)
  @JsonProperty("anchor")
  String anchor();

  /**
   * Unique ID per rule, tracker ID is stored with the rule in config.xml for user added rules, or check /tmp/rules.debug
   * @return
   */
  @Nullable
  @Index(3)
  @JsonProperty("tracker")
  String tracker();

  /**
   * Real interface for the log entry (e.g. em0)
   * @return
   */
  @Nullable
  @Index(4)
  @JsonProperty("real-interface")
  String realInterface();

  /**
   * Reason for the log entry (typically "match")
   * @return
   */
  @Nullable
  @Index(5)
  @JsonProperty("reason")
  String reason();

  /**
   * Action taken that resulted in the log entry
   * @return
   */
  @Nullable
  @Index(6)
  @JsonProperty("action")
  Action action();

  /**
   * Direction of the logged traffic
   * @return
   */
  @Nullable
  @Index(7)
  @JsonProperty("direction")
  Direction direction();

  @Nullable
  @Index(7)
  @JsonProperty("ip-version")
  Integer ipVersion();

  public enum Action {
    Pass,
    Block
  }

  public enum Direction {
    In,
    Out
  }
}
