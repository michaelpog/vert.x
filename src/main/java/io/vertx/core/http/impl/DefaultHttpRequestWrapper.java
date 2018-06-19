package io.vertx.core.http.impl;
import java.util.ArrayList;
import java.util.List;

import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpVersion;

public class DefaultHttpRequestWrapper implements HttpRequest {
  private DefaultHttpRequest defaultHttpRequest;
  private List<TimeStampVertx> timeStamps = new ArrayList<>();

  public DefaultHttpRequestWrapper(DefaultHttpRequest defaultHttpRequest) {
    this.defaultHttpRequest = defaultHttpRequest;
  }

  @Override
  public HttpMethod getMethod() {
    return defaultHttpRequest.getMethod();
  }

  @Override
  public HttpMethod method() {
    return defaultHttpRequest.method();
  }

  @Override
  public HttpRequest setMethod(HttpMethod httpMethod) {
    defaultHttpRequest.setMethod(httpMethod);
    return this;
  }

  @Override
  public String getUri() {
    return defaultHttpRequest.getUri();
  }

  @Override
  public String uri() {
    return defaultHttpRequest.uri();
  }

  @Override
  public HttpRequest setUri(String s) {
    defaultHttpRequest.setUri(s);
    return this;
  }

  @Override
  public HttpVersion getProtocolVersion() {
    return defaultHttpRequest.getProtocolVersion();
  }

  @Override
  public HttpVersion protocolVersion() {
    return this.defaultHttpRequest.protocolVersion();
  }

  @Override
  public HttpRequest setProtocolVersion(HttpVersion httpVersion) {
    defaultHttpRequest.setProtocolVersion(httpVersion);
    return this;
  }

  @Override
  public HttpHeaders headers() {
    return defaultHttpRequest.headers();
  }

  @Override
  public DecoderResult getDecoderResult() {
    return defaultHttpRequest.getDecoderResult();
  }

  @Override
  public DecoderResult decoderResult() {
    return defaultHttpRequest.decoderResult();
  }

  @Override
  public void setDecoderResult(DecoderResult decoderResult) {
    this.defaultHttpRequest.setDecoderResult(decoderResult);
  }

  public List<TimeStampVertx> getTimeStamps() {
    return this.timeStamps;
  }

  public void captureTime(String name) {
    TimeStampVertx timeStamp = new TimeStampVertx();
    timeStamp.name = name;
    timeStamp.timestamp = System.currentTimeMillis();
    this.timeStamps.add(timeStamp);
  }

  public static class TimeStampVertx {
    public String name;
    public long timestamp;
  }
}
