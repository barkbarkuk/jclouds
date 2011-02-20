/**
 *
 * Copyright (C) 2010 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.jclouds.cloudstack.options;

import org.jclouds.http.options.BaseHttpRequestOptions;

import com.google.common.collect.ImmutableSet;

/**
 * Options used to control what ip forwarding rules are returned
 * 
 * @see <a href="http://download.cloud.com/releases/2.2.0/api/user/listIpForwardingRules.html" />
 * @author Adrian Cole
 */
public class ListIPForwardingRulesOptions extends BaseHttpRequestOptions {

   public static final ListIPForwardingRulesOptions NONE = new ListIPForwardingRulesOptions();

   /**
    * @param id
    *           Lists rule with the specified ID.
    */
   public ListIPForwardingRulesOptions id(long id) {
      this.queryParameters.replaceValues("id", ImmutableSet.of(id + ""));
      return this;
   }

   /**
    * @param domainId
    *           Lists all rules for this id. If used with the account parameter, returns all rules
    *           for an account in the specified domain ID.
    */
   public ListIPForwardingRulesOptions domainId(long domainId) {
      this.queryParameters.replaceValues("domainid", ImmutableSet.of(domainId + ""));
      return this;

   }

   /**
    * @param account
    *           the account associated with the ip forwarding rule. Must be used with the domainId
    *           parameter.
    */
   public ListIPForwardingRulesOptions account(String account) {
      this.queryParameters.replaceValues("account", ImmutableSet.of(account));
      return this;
   }

   /**
    * @param IPAddressId
    *           list the rule belonging to this public ip address
    */
   public ListIPForwardingRulesOptions IPAddressId(long IPAddressId) {
      this.queryParameters.replaceValues("ipaddressid", ImmutableSet.of(IPAddressId + ""));
      return this;

   }

   /**
    * @param virtualMachineId
    *           Lists all rules applied to the specified Vm.
    */
   public ListIPForwardingRulesOptions virtualMachineId(long virtualMachineId) {
      this.queryParameters.replaceValues("virtualmachineid", ImmutableSet.of(virtualMachineId + ""));
      return this;

   }

   public static class Builder {

      /**
       * @see ListIPForwardingRulesOptions#account
       */
      public static ListIPForwardingRulesOptions account(String account) {
         ListIPForwardingRulesOptions options = new ListIPForwardingRulesOptions();
         return options.account(account);
      }

      /**
       * @see ListIPForwardingRulesOptions#IPAddressId
       */
      public static ListIPForwardingRulesOptions IPAddressId(long IPAddressId) {
         ListIPForwardingRulesOptions options = new ListIPForwardingRulesOptions();
         return options.IPAddressId(IPAddressId);
      }

      /**
       * @see ListIPForwardingRulesOptions#domainId
       */
      public static ListIPForwardingRulesOptions domainId(long id) {
         ListIPForwardingRulesOptions options = new ListIPForwardingRulesOptions();
         return options.domainId(id);
      }

      /**
       * @see ListIPForwardingRulesOptions#id
       */
      public static ListIPForwardingRulesOptions id(long id) {
         ListIPForwardingRulesOptions options = new ListIPForwardingRulesOptions();
         return options.id(id);
      }

      /**
       * @see ListIPForwardingRulesOptions#virtualMachineId
       */
      public static ListIPForwardingRulesOptions virtualMachineId(long virtualMachineId) {
         ListIPForwardingRulesOptions options = new ListIPForwardingRulesOptions();
         return options.virtualMachineId(virtualMachineId);
      }
   }
}